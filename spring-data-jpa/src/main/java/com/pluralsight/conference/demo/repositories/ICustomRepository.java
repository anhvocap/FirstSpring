package com.pluralsight.conference.demo.repositories;

import com.pluralsight.conference.demo.models.Session;

import java.util.List;

public interface ICustomRepository {
    List<Session> customQuerySessions();
}
