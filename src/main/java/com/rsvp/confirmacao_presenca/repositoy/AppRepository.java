package com.rsvp.confirmacao_presenca.repositoy;

import java.lang.invoke.MethodHandles;

import org.springframework.web.context.annotation.ApplicationScope;

import java.util.logging.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScope
public class AppRepository {
    protected static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @PersistenceContext
    protected EntityManager em;

}
