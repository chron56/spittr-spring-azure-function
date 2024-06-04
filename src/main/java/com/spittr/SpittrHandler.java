package com.spittr;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import com.spittr.service.SpittrService;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class SpittrHandler {

    @Autowired
    public SpittrService spittrService;

    @FunctionName("getAllSpitters")
    public HttpResponseMessage listSpitters(
            @HttpTrigger(
                    name = "request",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "spitters")
            HttpRequestMessage<Optional> request, ExecutionContext context) {

        context.getLogger().info("Get All spitters");
        List<Spitter> spitters = spittrService.getAllSpitters();
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(spitters)
                .header("Content-Type", "application/json")
                .build();
    }

    @FunctionName("getSpitter")
    public HttpResponseMessage getSpitterById(
            @HttpTrigger(
                    name = "request",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "spitters/{id}")
            HttpRequestMessage<Optional> request, @BindingName("id") int id, ExecutionContext context) {

        context.getLogger().info("Get spitter");
        Spitter spitter = spittrService.getSpitterById(id);
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(spitter)
                .header("Content-Type", "application/json")
                .build();
    }

    @FunctionName("addSpitter")
    public HttpResponseMessage createSpitter(
            @HttpTrigger(
                    name = "request",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "spitters/add")
            HttpRequestMessage<Spitter> request, ExecutionContext context) {

        context.getLogger().info("Add spitter");
        spittrService.saveSpitter(request.getBody());
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body("Added")
                .build();
    }

    @FunctionName("deleteSpitter")
    public HttpResponseMessage deleteSpitterById(
            @HttpTrigger(
                    name = "request",
                    methods = {HttpMethod.DELETE},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "spitters/delete/{id}")
            HttpRequestMessage<Optional> request, @BindingName("id") int id, ExecutionContext context) {

        context.getLogger().info("Delete spitter");
        spittrService.deleteSpitterById(id);
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body("Deleted")
                .build();
    }

    @FunctionName("getAllSpittles")
    public HttpResponseMessage listSpittles(
            @HttpTrigger(
                    name = "request",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "spittles")
            HttpRequestMessage<Optional> request, ExecutionContext context) {

        context.getLogger().info("Get All spittles");
        List<Spittle> spittles = spittrService.getAllSpittles();
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(spittles)
                .header("Content-Type", "application/json")
                .build();
    }

}