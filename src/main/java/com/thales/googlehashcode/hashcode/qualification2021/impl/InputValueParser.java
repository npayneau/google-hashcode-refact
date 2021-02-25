package com.thales.googlehashcode.hashcode.qualification2021.impl;

import com.thales.googlehashcode.hashcode.common.HashCodeInputValueParser;
import com.thales.googlehashcode.hashcode.qualification2021.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class InputValueParser implements HashCodeInputValueParser<InputValue> {

    @Override
    public InputValue parse(Scanner scanner) {
        final String[] firstLine = scanner.nextLine().split(" ");
        GlobalConfig gc = GlobalConfig.builder().duration(Integer.parseInt(firstLine[0])).intersectionNumber(Integer.parseInt(firstLine[1])).streetNumber(Integer.parseInt(firstLine[2])).carNumber(Integer.parseInt(firstLine[3])).scoringPoint(Integer.parseInt(firstLine[4])).build();
        Map<Integer, List<Schedule>> mapOfInterSection = new HashMap<>();
        Set<Intersection> intersectionList = new HashSet<>();
        List<Street> streets = new ArrayList<>();
        for (int i = 0; i < gc.getStreetNumber(); i++) {
            final String[] streetLine = scanner.nextLine().split(" ");
            final Street street = Street.builder().startingPoint(Integer.parseInt(streetLine[0])).endingPoint(Integer.parseInt(streetLine[1])).name(streetLine[2]).duration(Integer.parseInt(streetLine[3])).build();
            streets.add(street);
            List<Schedule> scheduleOfIntersection = mapOfInterSection.get(street.getEndingPoint());
            if (scheduleOfIntersection == null) scheduleOfIntersection = new ArrayList<>();
            scheduleOfIntersection.add(new Schedule(street, 0));
            mapOfInterSection.put(street.getEndingPoint(), scheduleOfIntersection);
        }

        intersectionList = mapOfInterSection.entrySet().stream().map(integerListEntry -> new Intersection(integerListEntry.getKey(), integerListEntry.getValue())).collect(Collectors.toSet());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < gc.getCarNumber(); i++) {
            final String[] carLine = scanner.nextLine().split(" ");
            LinkedList<Street> streetsTmp = new LinkedList<>();
            for (int j = 1; j <= Integer.parseInt(carLine[0]); j++) {
                int finalJ = j;
                streetsTmp.add(streets.stream().filter(street -> street.getName().equals(carLine[finalJ])).collect(Collectors.toList()).get(0));
            }
            cars.add(Car.builder().streetCount(Integer.parseInt(carLine[0])).streetsToVisit(streetsTmp).totalTimePath(streetsTmp.stream().mapToInt(Street::getDuration).sum()-streetsTmp.getFirst().getDuration()).build());
        }
        return InputValue.builder().globalConfig(gc).allStreets(streets).cars(cars).intersections(intersectionList).build();
    }
}
