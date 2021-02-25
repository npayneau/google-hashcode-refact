package com.thales.googlehashcode.hashcode.qualification2021.impl;

import com.thales.googlehashcode.hashcode.common.HashCodeInputValueParser;
import com.thales.googlehashcode.hashcode.qualification2021.model.Car;
import com.thales.googlehashcode.hashcode.qualification2021.model.GlobalConfig;
import com.thales.googlehashcode.hashcode.qualification2021.model.InputValue;
import com.thales.googlehashcode.hashcode.qualification2021.model.Street;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputValueParser implements HashCodeInputValueParser<InputValue> {

    @Override
    public InputValue parse(Scanner scanner) {
        final String[] firstLine = scanner.nextLine().split(" ");
        GlobalConfig gc = GlobalConfig.builder().duration(Integer.parseInt(firstLine[0])).intersectionNumber(Integer.parseInt(firstLine[1])).streetNumber(Integer.parseInt(firstLine[2])).carNumber(Integer.parseInt(firstLine[3])).scoringPoint(Integer.parseInt(firstLine[4])).build();

        List<Street> streets = new ArrayList<>();
        for (int i = 0; i < gc.getStreetNumber(); i++) {
            final String[] streetLine = scanner.nextLine().split(" ");
            streets.add(Street.builder().startingPoint(Integer.parseInt(streetLine[0])).endingPoint(Integer.parseInt(streetLine[1])).name(streetLine[2]).duration(Integer.parseInt(streetLine[3])).build());
        }

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < gc.getCarNumber(); i++) {
            final String[] carLine = scanner.nextLine().split(" ");
            LinkedList<Street> streetsTmp = new LinkedList<>();
            for (int j = 1; j <= Integer.parseInt(carLine[0]); j++) {
                int finalJ = j;
                streetsTmp.add(streets.stream().filter(street -> street.getName().equals(carLine[finalJ])).collect(Collectors.toList()).get(0));
            }
            cars.add(Car.builder().streetCount(Integer.parseInt(carLine[0])).streetsToVisit(streetsTmp).totalTimePath(streetsTmp.stream().mapToInt(Street::getDuration).sum()).build());
        }
        return InputValue.builder().globalConfig(gc).allStreets(streets).cars(cars).build();
    }
}
