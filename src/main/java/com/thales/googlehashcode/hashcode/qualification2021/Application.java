package com.thales.googlehashcode.hashcode.qualification2021;

import com.thales.googlehashcode.hashcode.common.HashCodeApplication;
import com.thales.googlehashcode.hashcode.common.HashCodePhase;
import com.thales.googlehashcode.hashcode.common.HashCodeSession;
import com.thales.googlehashcode.hashcode.qualification2021.impl.Algorithm;
import com.thales.googlehashcode.hashcode.qualification2021.impl.InputValueParser;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        final HashCodeSession session = new HashCodeSession(2021, HashCodePhase.QUALIFICATION);
        final HashCodeApplication hashCodeApplication = new HashCodeApplication(session);
        hashCodeApplication.run(new Algorithm(), new InputValueParser());
    }
}
