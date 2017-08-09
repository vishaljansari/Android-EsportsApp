package com.esports.vishal.esportsscoreapplication.CSGO;

/**
 * Created by VISHAL on 7/26/2017.
 */

public class CsGoItem {

        private String season_name;
        private String sport_name;
        private String sports_category_name;
        private String dateandtimeofgame;
        private String team_2_name;
        private String team_1_name;
        private String team_1_abbreviation;
        private String team_2_abbreviation;
        private String team_1_qualifier;
        private String team_2_qualifier;
        private String team_1_country;
        private String team_2_country;
        private String team_1_country_code;
        private String team_2_country_code;
        private String team_1_home_score;
        private String team_2_home_score;
        private String away_score;
        private String tournament_type;

        private String team_1_home_score_period;
        private String team_2_home_score_period;
        private String tournament_name;
        private String sport_event_status;

    public CsGoItem(String dateandtimeofgame, String season_name, String team_1_name, String team_2_name, String tournament_type, String tournament_name,String team_1_abbreviation,String team_2_abbreviation,String team_1_qualifier, String team_2_qualifier,String team_1_home_score,String team_2_home_score,String team_1_home_score_period, String team_2_home_score_period) {

        this.dateandtimeofgame = dateandtimeofgame;
        this.season_name = season_name;
        this.team_1_name = team_1_name;
        this.team_2_name = team_2_name;
        this.tournament_type = tournament_type;
        this.tournament_name = tournament_name;
        this.team_1_abbreviation = team_1_abbreviation;
        this.team_2_abbreviation = team_2_abbreviation;
        this.team_1_qualifier = team_1_qualifier;
        this.team_2_qualifier = team_2_qualifier;
        this.team_1_home_score = team_1_home_score;
        this.team_2_home_score = team_2_home_score;
        this.team_1_home_score_period  = team_1_home_score_period;
        this.team_2_home_score_period=team_2_home_score_period;
    }


    public String getTeam_1_name() {
        return team_1_name;
    }

    public void setTeam_1_name(String team_1_name) {
        this.team_1_name = team_1_name;
    }

    public String getTeam_2_name() {
        return team_2_name;
    }

    public void setTeam_2_name(String team_2_name) {
        this.team_2_name = team_2_name;
    }
    public String getTournament_type() {
        return tournament_type;
    }

    public void setTournament_type(String tournament_type) {
        this.tournament_type = tournament_type;
    }


    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public String getSport_name() {
        return sport_name;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public String getSports_category_name() {
        return sports_category_name;
    }

    public void setSports_category_name(String sports_category_name) {
        this.sports_category_name = sports_category_name;
    }

    public String getDateandtimeofgame() {
        return dateandtimeofgame;
    }

    public void setDateandtimeofgame(String dateandtimeofgame) {
        this.dateandtimeofgame = dateandtimeofgame;
    }

    public String getTeam_1_abbreviation() {
        return team_1_abbreviation;
    }

    public void setTeam_1_abbreviation(String team_1_abbreviation) {
        this.team_1_abbreviation = team_1_abbreviation;
    }

    public String getTeam_2_abbreviation() {
        return team_2_abbreviation;
    }

    public void setTeam_2_abbreviation(String team_2_abbreviation) {
        this.team_2_abbreviation = team_2_abbreviation;
    }

    public String getTeam_1_qualifier() {
        return team_1_qualifier;
    }

    public void setTeam_1_qualifier(String team_1_qualifier) {
        this.team_1_qualifier = team_1_qualifier;
    }

    public String getTeam_2_qualifier() {
        return team_2_qualifier;
    }

    public void setTeam_2_qualifier(String team_2_qualifier) {
        this.team_2_qualifier = team_2_qualifier;
    }

    public String getTeam_1_country() {
        return team_1_country;
    }

    public void setTeam_1_country(String team_1_country) {
        this.team_1_country = team_1_country;
    }

    public String getTeam_2_country() {
        return team_2_country;
    }

    public void setTeam_2_country(String team_2_country) {
        this.team_2_country = team_2_country;
    }

    public String getTeam_1_country_code() {
        return team_1_country_code;
    }

    public void setTeam_1_country_code(String team_1_country_code) {
        this.team_1_country_code = team_1_country_code;
    }

    public String getTeam_2_country_code() {
        return team_2_country_code;
    }

    public void setTeam_2_country_code(String team_2_country_code) {
        this.team_2_country_code = team_2_country_code;
    }

    public String getTeam_1_home_score() {
        return team_1_home_score;
    }

    public void setTeam_1_home_score(String team_1_home_score) {
        this.team_1_home_score = team_1_home_score;
    }

    public String getTeam_2_home_score() {
        return team_2_home_score;
    }

    public void setTeam_2_home_score(String team_2_home_score) {
        this.team_2_home_score = team_2_home_score;
    }

    public String getTeam_1_home_score_period() {
        return team_1_home_score_period;
    }

    public void setTeam_1_home_score_period(String team_1_home_score_period) {
        this.team_1_home_score_period = team_1_home_score_period;
    }

    public String getTeam_2_home_score_period() {
        return team_2_home_score_period;
    }

    public void setTeam_2_home_score_period(String team_2_home_score_period) {
        this.team_2_home_score_period = team_2_home_score_period;
    }

    public String getSport_event_status() {
        return sport_event_status;
    }

    public void setSport_event_status(String sport_event_status) {
        this.sport_event_status = sport_event_status;
    }
}
