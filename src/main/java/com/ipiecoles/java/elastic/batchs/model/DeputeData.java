package com.ipiecoles.java.elastic.batchs.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "depute")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DeputeData {
    @Id
    private Long id;
    private String nom;
    private String nomDeFamille;
    private String prenom;
    private String sexe;
    private String dateNaissance;
    private String lieuNaissance;
    private Boolean actif;
    private String numDeptmt;
    private String nomCirco;
    private String groupe;
    private Integer numCirco;
    private String mandatDebut;
    private String mandatFin;
    private Integer ancienDepute;
    private String groupeSigle;
    private String partiRattFinancier;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<SiteWeb> sitesWeb;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Email> emails;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Adresse> adresses;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Collaborateur> collaborateurs;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Mandat> anciensMandats;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Mandat> anciensAutresMandats;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Mandat> autresMandats;
    private Integer nbMandatsTotal;
    private String profession;
    private String placeEnHemicycle;
    private String urlAn;
    private String idAn;
    private String slug;
    private String urlNosdeputes;
    private String urlNosdeputesApi;
    private Integer nbMandats;
    private String twitter;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomDeFamille() {
        return nomDeFamille;
    }

    public void setNomDeFamille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNumDeptmt() {
        return numDeptmt;
    }

    public void setNumDeptmt(String numDeptmt) {
        this.numDeptmt = numDeptmt;
    }

    public String getNomCirco() {
        return nomCirco;
    }

    public void setNomCirco(String nomCirco) {
        this.nomCirco = nomCirco;
    }

    public Integer getNumCirco() {
        return numCirco;
    }

    public void setNumCirco(Integer numCirco) {
        this.numCirco = numCirco;
    }

    public String getMandatDebut() {
        return mandatDebut;
    }

    public void setMandatDebut(String mandatDebut) {
        this.mandatDebut = mandatDebut;
    }

    public String getGroupeSigle() {
        return groupeSigle;
    }

    public void setGroupeSigle(String groupeSigle) {
        this.groupeSigle = groupeSigle;
    }

    public String getPartiRattFinancier() {
        return partiRattFinancier;
    }

    public void setPartiRattFinancier(String partiRattFinancier) {
        this.partiRattFinancier = partiRattFinancier;
    }

    public List<SiteWeb> getSitesWeb() {
        return sitesWeb;
    }

    public void setSitesWeb(List<SiteWeb> sitesWeb) {
        this.sitesWeb = sitesWeb;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Mandat> getAnciensMandats() {
        return anciensMandats;
    }

    public void setAnciensMandats(List<Mandat> anciensMandats) {
        this.anciensMandats = anciensMandats;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPlaceEnHemicycle() {
        return placeEnHemicycle;
    }

    public void setPlaceEnHemicycle(String placeEnHemicycle) {
        this.placeEnHemicycle = placeEnHemicycle;
    }

    public String getUrlAn() {
        return urlAn;
    }

    public void setUrlAn(String urlAn) {
        this.urlAn = urlAn;
    }

    public String getIdAn() {
        return idAn;
    }

    public void setIdAn(String idAn) {
        this.idAn = idAn;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrlNosdeputes() {
        return urlNosdeputes;
    }

    public void setUrlNosdeputes(String urlNosdeputes) {
        this.urlNosdeputes = urlNosdeputes;
    }

    public String getUrlNosdeputesApi() {
        return urlNosdeputesApi;
    }

    public void setUrlNosdeputesApi(String urlNosdeputesApi) {
        this.urlNosdeputesApi = urlNosdeputesApi;
    }

    public Integer getNbMandats() {
        return nbMandats;
    }

    public void setNbMandats(Integer nbMandats) {
        this.nbMandats = nbMandats;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
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

    public Integer getNbMandatsTotal() {
        return nbMandatsTotal;
    }

    public void setNbMandatsTotal(Integer nbMandatsTotal) {
        this.nbMandatsTotal = nbMandatsTotal;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getMandatFin() {
        return mandatFin;
    }

    public void setMandatFin(String mandatFin) {
        this.mandatFin = mandatFin;
    }

    public List<Mandat> getAnciensAutresMandats() {
        return anciensAutresMandats;
    }

    public void setAnciensAutresMandats(List<Mandat> anciensAutresMandats) {
        this.anciensAutresMandats = anciensAutresMandats;
    }

    public List<Mandat> getAutresMandats() {
        return autresMandats;
    }

    public void setAutresMandats(List<Mandat> autresMandats) {
        this.autresMandats = autresMandats;
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public List<Collaborateur> getCollaborateurs() {
        return collaborateurs;
    }

    public void setCollaborateurs(List<Collaborateur> collaborateurs) {
        this.collaborateurs = collaborateurs;
    }

    public Integer getAncienDepute() {
        return ancienDepute;
    }

    public void setAncienDepute(Integer ancienDepute) {
        this.ancienDepute = ancienDepute;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}
