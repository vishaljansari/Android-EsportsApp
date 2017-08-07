package com.esports.vishal.esportsscoreapplication.LOL;

/**
 * Created by sagar on 8/4/17.
 */

public class LolItem {
    private String l_season_name;
    private String l_sport_name;
    private String l_sports_category_name;
    private String l_dateandtimeofgame;
    private String l_team_1_abbreviation;
    private String l_team_2_abbreviation;
    private String l_team_1_qualifier;
    private String l_team_2_qualifier;
    private String l_team_1_country;
    private String l_team_2_country;
    private String l_team_1_country_code;
    private String l_team_2_country_code;
    private int l_home_score;
    private int l_away_score;

    public LolItem(String l_dateandtimeofgame, String l_season_name, String l_team_1_abbreviation) {

        this.l_dateandtimeofgame = l_dateandtimeofgame;
        this.l_season_name = l_season_name;
        this.l_team_1_abbreviation = l_team_1_abbreviation;
    }

    public String getL_season_name() {
        return l_season_name;
    }

    public void setL_season_name(String l_season_name) {
        this.l_season_name = l_season_name;
    }

    public String getL_sport_name() {
        return l_sport_name;
    }

    public void setL_sport_name(String l_sport_name) {
        this.l_sport_name = l_sport_name;
    }

    public String getL_sports_category_name() {
        return l_sports_category_name;
    }

    public void setL_sports_category_name(String l_sports_category_name) {
        this.l_sports_category_name = l_sports_category_name;
    }

    public String getL_dateandtimeofgame() {
        return l_dateandtimeofgame;
    }

    public void setL_dateandtimeofgame(String l_dateandtimeofgame) {
        this.l_dateandtimeofgame = l_dateandtimeofgame;
    }

    public String getL_team_1_abbreviation() {
        return l_team_1_abbreviation;
    }

    public void setL_team_1_abbreviation(String l_team_1_abbreviation) {
        this.l_team_1_abbreviation = l_team_1_abbreviation;
    }

    public String getL_team_2_abbreviation() {
        return l_team_2_abbreviation;
    }

    public void setL_team_2_abbreviation(String l_team_2_abbreviation) {
        this.l_team_2_abbreviation = l_team_2_abbreviation;
    }

    public String getL_team_1_qualifier() {
        return l_team_1_qualifier;
    }

    public void setL_team_1_qualifier(String l_team_1_qualifier) {
        this.l_team_1_qualifier = l_team_1_qualifier;
    }

    public String getL_team_2_qualifier() {
        return l_team_2_qualifier;
    }

    public void setL_team_2_qualifier(String l_team_2_qualifier) {
        this.l_team_2_qualifier = l_team_2_qualifier;
    }

    public String getL_team_1_country() {
        return l_team_1_country;
    }

    public void setL_team_1_country(String l_team_1_country) {
        this.l_team_1_country = l_team_1_country;
    }

    public String getL_team_2_country() {
        return l_team_2_country;
    }

    public void setL_team_2_country(String l_team_2_country) {
        this.l_team_2_country = l_team_2_country;
    }

    public String getL_team_1_country_code() {
        return l_team_1_country_code;
    }

    public void setL_team_1_country_code(String l_team_1_country_code) {
        this.l_team_1_country_code = l_team_1_country_code;
    }

    public String getL_team_2_country_code() {
        return l_team_2_country_code;
    }

    public void setL_team_2_country_code(String l_team_2_country_code) {
        this.l_team_2_country_code = l_team_2_country_code;
    }

    public int getL_home_score() {
        return l_home_score;
    }

    public void setL_home_score(int l_home_score) {
        this.l_home_score = l_home_score;
    }

    public int getL_away_score() {
        return l_away_score;
    }

    public void setL_away_score(int l_away_score) {
        this.l_away_score = l_away_score;
    }
}
