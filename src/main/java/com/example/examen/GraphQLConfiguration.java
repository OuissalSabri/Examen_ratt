package com.example.examen;

import graphql.GraphQL;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfiguration {

    @Bean
    public GraphQL graphQL(GraphQLSchema graphQLSchema) {
        return GraphQL.newGraphQL(graphQLSchema).build();
    }

    @Bean
    public GraphQLSchema graphQLSchema(GraphQLController graphQLController) {
        return SchemaParser.newParser()
                .file("/schema.graphqls") // Chemin vers le fichier GraphQL SDL
                .resolvers(graphQLController)
                .build()
                .makeExecutableSchema();
    }
}