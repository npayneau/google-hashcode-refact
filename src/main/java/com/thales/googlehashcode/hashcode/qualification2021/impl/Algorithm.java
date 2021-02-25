package com.thales.googlehashcode.hashcode.qualification2021.impl;

import com.thales.googlehashcode.hashcode.common.HashCodeAlgorithm;
import com.thales.googlehashcode.hashcode.common.HashCodeLogger;
import com.thales.googlehashcode.hashcode.common.HashCodeSolution;
import com.thales.googlehashcode.hashcode.qualification2021.model.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithm implements HashCodeAlgorithm<InputValue> {

    @Override
    public HashCodeSolution run(InputValue input, HashCodeLogger logger) {

        for (int index= 0; index < input.globalConfig.getDuration(); index++){
            State currentState=  new State();
            List<Street> streetsAtTheBeginningWithCars = input.cars.stream().map(car ->
                    car.getStreetsToVisit().stream().findFirst()
            ).flatMap(Optional::stream).collect(Collectors.toList());
            List<StreetState> streetStates = streetsAtTheBeginningWithCars.stream().distinct().map(street -> {
                LinkedList<Car> carsFromStreet = findCarsFromStreet(street, input.cars);
                return new StreetState(street, carsFromStreet);
            }).collect(Collectors.toList());
            int indexStreet = 0;
            while (true){
                final int currentIndexStreet = indexStreet;
                List<StreetState> allEndingStreet = streetStates.stream()
                        .filter(streetState -> streetState.getCurrent().getEndingPoint().equals(currentIndexStreet)).collect(Collectors.toList());
                if (allEndingStreet.size() == 0){
                    break;
                }
                IntersectionState intersectionState = new IntersectionState();
                intersectionState.setIndexIntersection(currentIndexStreet);
                intersectionState.setStreetStates(allEndingStreet);
                currentState.getIntersectionStates().add(intersectionState);
                indexStreet ++;
            }
            System.out.println("All incoming : "+currentState);
        }


        return null;
    }

    LinkedList<Car> findCarsFromStreet(Street street, List<Car> cars){
      return  cars.stream()
              .filter(car -> car.getStreetsToVisit().stream().findFirst().get().equals(street))
              .collect(Collectors.toCollection(LinkedList::new));
    }
}
