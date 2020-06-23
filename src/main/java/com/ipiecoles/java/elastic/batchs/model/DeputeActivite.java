package com.ipiecoles.java.elastic.batchs.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Document(indexName = "activite")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DeputeActivite {

    @Id
    private String id;
    private String nom;
    private String date;
    private String groupe;
    private Integer semainesPresence;
    private Integer commissionPresences;
    private Integer commissionInterventions;
    private Integer hemicycleInterventions;
    private Integer hemicycleInterventionsCourtes;
    private Integer amendementsProposes;
    private Integer amendementsSignes;
    private Integer amendementsAdoptes;
    private Integer rapports;
    private Integer propositionsEcrites;
    private Integer propositionsSignees;
    private Integer questionsEcrites;
    private Integer questionsOrales;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getSemainesPresence() {
        return semainesPresence;
    }

    public void setSemainesPresence(Integer semainesPresence) {
        this.semainesPresence = semainesPresence;
    }

    public Integer getCommissionPresences() {
        return commissionPresences;
    }

    public void setCommissionPresences(Integer commissionPresences) {
        this.commissionPresences = commissionPresences;
    }

    public Integer getCommissionInterventions() {
        return commissionInterventions;
    }

    public void setCommissionInterventions(Integer commissionInterventions) {
        this.commissionInterventions = commissionInterventions;
    }

    public Integer getHemicycleInterventions() {
        return hemicycleInterventions;
    }

    public void setHemicycleInterventions(Integer hemicycleInterventions) {
        this.hemicycleInterventions = hemicycleInterventions;
    }

    public Integer getHemicycleInterventionsCourtes() {
        return hemicycleInterventionsCourtes;
    }

    public void setHemicycleInterventionsCourtes(Integer hemicycleInterventionsCourtes) {
        this.hemicycleInterventionsCourtes = hemicycleInterventionsCourtes;
    }

    public Integer getAmendementsProposes() {
        return amendementsProposes;
    }

    public void setAmendementsProposes(Integer amendementsProposes) {
        this.amendementsProposes = amendementsProposes;
    }

    public Integer getAmendementsSignes() {
        return amendementsSignes;
    }

    public void setAmendementsSignes(Integer amendementsSignes) {
        this.amendementsSignes = amendementsSignes;
    }

    public Integer getAmendementsAdoptes() {
        return amendementsAdoptes;
    }

    public void setAmendementsAdoptes(Integer amendementsAdoptes) {
        this.amendementsAdoptes = amendementsAdoptes;
    }

    public Integer getRapports() {
        return rapports;
    }

    public void setRapports(Integer rapports) {
        this.rapports = rapports;
    }

    public Integer getPropositionsEcrites() {
        return propositionsEcrites;
    }

    public void setPropositionsEcrites(Integer propositionsEcrites) {
        this.propositionsEcrites = propositionsEcrites;
    }

    public Integer getPropositionsSignees() {
        return propositionsSignees;
    }

    public void setPropositionsSignees(Integer propositionsSignees) {
        this.propositionsSignees = propositionsSignees;
    }

    public Integer getQuestionsEcrites() {
        return questionsEcrites;
    }

    public void setQuestionsEcrites(Integer questionsEcrites) {
        this.questionsEcrites = questionsEcrites;
    }

    public Integer getQuestionsOrales() {
        return questionsOrales;
    }

    public void setQuestionsOrales(Integer questionsOrales) {
        this.questionsOrales = questionsOrales;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String  getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }
}

