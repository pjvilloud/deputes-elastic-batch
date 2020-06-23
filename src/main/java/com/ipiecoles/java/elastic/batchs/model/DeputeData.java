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
    @Field(name="id")
    private Long id;
    @Field(name="nom")
    private String nom;
    @Field(name="nom_de_famille")
    private String nomDeFamille;
    @Field(name="prenom")
    private String prenom;
    @Field(name="sexe")
    private String sexe;
    @Field(name="date_naissance")
    private String dateNaissance;
    @Field(name="lieu_naissance")
    private String lieuNaissance;
    @Field(name="actif")
    private Boolean actif;
    @Field(name="num_deptmt")
    private String numDeptmt;
    @Field(name="nom_circo")
    private String nomCirco;
    @Field(name="groupe")
    private String groupe;
    @Field(name="num_circo")
    private Integer numCirco;
    @Field(name="mandat_debut")
    private String mandatDebut;
    @Field(name="mandat_fin")
    private String mandatFin;
    @Field(name="ancien_depute")
    private Integer ancienDepute;
    @Field(name="groupe_sigle")
    private String groupeSigle;
    @Field(name="parti_ratt_financier")
    private String partiRattFinancier;
    @Field(type = FieldType.Nested, includeInParent = true, name = "sites_web")
    private List<SiteWeb> sitesWeb;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Email> emails;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Adresse> adresses;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Collaborateur> collaborateurs;
    @Field(type = FieldType.Nested, includeInParent = true, name = "anciens_mandats")
    private List<Mandat> anciensMandats;
    @Field(type = FieldType.Nested, includeInParent = true, name = "anciens_autres_mandats")
    private List<Mandat> anciensAutresMandats;
    @Field(type = FieldType.Nested, includeInParent = true, name = "autres_mandats")
    private List<Mandat> autresMandats;
    @Field(name="nb_mandats_total")
    private Integer nbMandatsTotal;
    @Field(name="profession")
    private String profession;
    @Field(name="place_en_hemicycle")
    private String placeEnHemicycle;
    @Field(name="url_an")
    private String urlAn;
    @Field(name="id_an")
    private String idAn;
    @Field(name="slug")
    private String slug;
    @Field(name="url_nosdeputes")
    private String urlNosdeputes;
    @Field(name="url_nosdeputes_api")
    private String urlNosdeputesApi;
    @Field(name="nb_mandats")
    private Integer nbMandats;
    @Field(name="twitter")
    private String twitter;
    @Field(name="semaines_presence")
    private Integer semainesPresence;
    @Field(name="commission_presences")
    private Integer commissionPresences;
    @Field(name="commission_interventions")
    private Integer commissionInterventions;
    @Field(name="hemicycle_interventions")
    private Integer hemicycleInterventions;
    @Field(name="hemicycle_interventions_courtes")
    private Integer hemicycleInterventionsCourtes;
    @Field(name="amendements_proposes")
    private Integer amendementsProposes;
    @Field(name="amendements_signes")
    private Integer amendementsSignes;
    @Field(name="amendements_adoptes")
    private Integer amendementsAdoptes;
    @Field(name="rapports")
    private Integer rapports;
    @Field(name="propositions_ecrites")
    private Integer propositionsEcrites;
    @Field(name="propositions_signees")
    private Integer propositionsSignees;
    @Field(name="questions_ecrites")
    private Integer questionsEcrites;
    @Field(name="questions_orales")
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

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
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

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
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

    public String getMandatFin() {
        return mandatFin;
    }

    public void setMandatFin(String mandatFin) {
        this.mandatFin = mandatFin;
    }

    public Integer getAncienDepute() {
        return ancienDepute;
    }

    public void setAncienDepute(Integer ancienDepute) {
        this.ancienDepute = ancienDepute;
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

    public List<Mandat> getAnciensMandats() {
        return anciensMandats;
    }

    public void setAnciensMandats(List<Mandat> anciensMandats) {
        this.anciensMandats = anciensMandats;
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

    public Integer getNbMandatsTotal() {
        return nbMandatsTotal;
    }

    public void setNbMandatsTotal(Integer nbMandatsTotal) {
        this.nbMandatsTotal = nbMandatsTotal;
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
}
