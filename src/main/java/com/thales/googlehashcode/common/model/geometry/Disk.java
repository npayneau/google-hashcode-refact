package com.thales.googlehashcode.common.model.geometry;

import com.thales.googlehashcode.common.impl.geometry.QuadraticEquation;

import java.util.List;

/**
 * Represents a disk. A disk is defined by a position, a speed
 * and a radius It contains final attributes and will thus returns
 * always a new instance on each operation.
 */
public class Disk {

    public final Vector position;
    public final Vector speed;
    private final double radius;

    /**
     * @param position the vector representing disk position
     * @param speed the vector representing disk speed
     * @param radius radius of the disk
     */
    public Disk(Vector position, Vector speed, double radius) {
        this.position = position;
        this.speed = speed;
        this.radius = radius;
    }

    /**
     * Moves the disk by its speed vector.
     *
     * @return a new instance of disk with the same speed but a position equals
     *         to position + speed
     */
    public Disk move() {
        return new Disk(position.add(speed), speed, radius);
    }

    /**
     * Modifies the disk speed adding an acceleration vector.
     *
     * @param acceleration the acceleration vector to be added to the speed vector
     * @return a new instance
     */
    public Disk accelerate(Vector acceleration) {
        return new Disk(position, speed.add(acceleration), radius);
    }

    /**
     * Modifies the speed of the disk by multiplying its current speed with the
     * given factor.
     *
     * @return a new instance with the same radius and position but a speed
     *         equals to speed * factor.
     */
    public Disk accelerate(double factor) {
        return new Disk(position, speed.multiply(factor), radius);
    }

    public Disk decelerate(double factor) {
        return accelerate(-factor);
    }

    /**
     * Identifies if the disk will collide with each other assuming that both
     * disks will remains with a constant speed. A collision occurs when the two
     * circles touch each other
     *
     * @param other the other disk
     * @return true if a collision will occurs
     */
    public boolean willCollide(Disk other) {
        Vector toOther = other.position.minus(position);
        Vector relativeSpeed = speed.minus(other.speed);

        if (relativeSpeed.lengthSquare() <= 0) // No relative movement
            return false;

        // Opposite directions
        final boolean b = toOther.dot(relativeSpeed) < 0;
        final double abs = Math.abs(relativeSpeed.normalized().orthogonal().dot(toOther));
        return !b && abs <= (radius + other.radius);
    }

    /**
     * Returns the shortest time when the two disks will collide considering
     * that each disk is moving at its speed vector by time unit A collision
     * occurs when the two circles touch each other Will return Double.MAX_VALUE
     * if no collision occurs
     *
     * @param other the other disk
     * @return the time of collision Double.MAX_VALUE if no collision occurs 0
     *         if the two disks are allready
     */
    public double collisionTime(Disk other) {
        final Vector toOther = other.position.minus(position);
        double distanceCollision = other.radius + radius;

        if (toOther.lengthSquare() <= distanceCollision * distanceCollision) {
            return 0;
        }

        final Vector relativeSpeed = speed.minus(other.speed);

        double a = relativeSpeed.lengthSquare();
        double b = -2 * relativeSpeed.dot(toOther);
        double c = toOther.lengthSquare() - distanceCollision * distanceCollision;

        List<Complex> solutions = QuadraticEquation.solve(a, b, c);

        if (solutions.size() == 0) {
            return Double.MAX_VALUE;
        }

        if (solutions.size() == 1) {
            double solution = solutions.get(0).getReal();

            if (solution >= 0) {
                return solution;
            }

            return Double.MAX_VALUE;
        }

        Complex root1 = solutions.get(0);

        if (!root1.isReal()) {
            return Double.MAX_VALUE;
        }

        double root1Solution = root1.getReal();

        if (root1Solution >= 0) {
            return root1Solution;
        }

        double root2Solution = solutions.get(1).getReal();

        if (root2Solution >= 0) {
            return root2Solution;
        }

        return Double.MAX_VALUE;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((speed == null) ? 0 : speed.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Disk other = (Disk) obj;

        if (position == null) {
            if (other.position != null) {
                return false;
            }
        } else if (!position.equals(other.position)) {
            return false;
        }

        if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }

        if (speed == null) {
            return (other.speed == null);
        } else return (speed.equals(other.speed));

    }
}
