package com.esports.vishal.esportsscoreapplication.DOTA2;

/**
 * Created by sagar on 8/4/17.
 */

public class Dota2Item {

    private String d_season_name;
    private String d_sport_name;
    private String d_sports_category_name;
    private String d_dateandtimeofgame;
    private String d_team_1_abbreviation;
    private String d_team_2_abbreviation;
    private String d_team_1_qualifier;
    private String d_team_2_qualifier;
    private String d_team_1_country;
    private String d_team_2_country;
    private String d_team_1_country_code;
    private String d_team_2_country_code;
    private int d_home_score;
    private int d_away_score;


    public Dota2Item(String d_dateandtimeofgame, String d_season_name)
    {
        this.d_dateandtimeofgame=d_dateandtimeofgame;
        this.d_season_name=d_season_name;
    }

    public String getD_season_name() {
        return d_season_name;
    }

    public void setD_season_name(String d_season_name) {
        this.d_season_name = d_season_name;
    }

    public String getD_sport_name() {
        return d_sport_name;
    }

    public void setD_sport_name(String d_sport_name) {
        this.d_sport_name = d_sport_name;
    }

    public String getD_sports_category_name() {
        return d_sports_category_name;
    }

    public void setD_sports_category_name(String d_sports_category_name) {
        this.d_sports_category_name = d_sports_category_name;
    }

    public String getD_dateandtimeofgame() {
        return d_dateandtimeofgame;
    }

    public void setD_dateandtimeofgame(String d_dateandtimeofgame) {
        this.d_dateandtimeofgame = d_dateandtimeofgame;
    }

    public String getD_team_1_abbreviation() {
        return d_team_1_abbreviation;
    }

    public void setD_team_1_abbreviation(String d_team_1_abbreviation) {
        this.d_team_1_abbreviation = d_team_1_abbreviation;
    }

    public String getD_team_2_abbreviation() {
        return d_team_2_abbreviation;
    }

    public void setD_team_2_abbreviation(String d_team_2_abbreviation) {
        this.d_team_2_abbreviation = d_team_2_abbreviation;
    }

    public String getD_team_1_qualifier() {
        return d_team_1_qualifier;
    }

    public void setD_team_1_qualifier(String d_team_1_qualifier) {
        this.d_team_1_qualifier = d_team_1_qualifier;
    }

    public String getD_team_2_qualifier() {
        return d_team_2_qualifier;
    }

    public void setD_team_2_qualifier(String d_team_2_qualifier) {
        this.d_team_2_qualifier = d_team_2_qualifier;
    }

    public String getD_team_1_country() {
        return d_team_1_country;
    }

    public void setD_team_1_country(String d_team_1_country) {
        this.d_team_1_country = d_team_1_country;
    }

    public String getD_team_2_country() {
        return d_team_2_country;
    }

    public void setD_team_2_country(String d_team_2_country) {
        this.d_team_2_country = d_team_2_country;
    }

    public String getD_team_1_country_code() {
        return d_team_1_country_code;
    }

    public void setD_team_1_country_code(String d_team_1_country_code) {
        this.d_team_1_country_code = d_team_1_country_code;
    }

    public String getD_team_2_country_code() {
        return d_team_2_country_code;
    }

    public void setD_team_2_country_code(String d_team_2_country_code) {
        this.d_team_2_country_code = d_team_2_country_code;
    }

    public int getD_home_score() {
        return d_home_score;
    }

    public void setD_home_score(int d_home_score) {
        this.d_home_score = d_home_score;
    }

    public int getD_away_score() {
        return d_away_score;
    }

    public void setD_away_score(int d_away_score) {
        this.d_away_score = d_away_score;
    }
}
