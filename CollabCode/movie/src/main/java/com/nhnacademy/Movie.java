package com.nhnacademy;

import java.time.LocalDate;
import org.apache.commons.csv.CSVRecord;

public class Movie {
    private int movieId;
    private String title;
    private String koreanTitle;
    private String plot;
    private int releaseYear;
    private int runningTime;
    private int gradeID;
    private int gradInKoreaID;
    private String poster;
    private LocalDate date;
    private long boxOfficeWWGross;
    private long boxOfficeUSGross;
    private long budget;
    private String originalAuthor;
    private String originalSource;

    public Movie() {
    }

//    public Movie(int movieId, String title, String koreanTitle, String plot, int releaseYear, int runningTime,
//                 int gradeID, int gradInKoreaID, String poster, LocalDate date, long boxOfficeWWGross,
//                 long boxOfficeUSGross, long budget, String originalAuthor, String originalSource) {
//        this.movieId = movieId;
//        this.title = title;
//        this.koreanTitle = koreanTitle;
//        this.plot = plot;
//        this.releaseYear = releaseYear;
//        this.runningTime = runningTime;
//        this.gradeID = gradeID;
//        this.gradInKoreaID = gradInKoreaID;
//        this.poster = poster;
//        this.date = date;
//        this.boxOfficeWWGross = boxOfficeWWGross;
//        this.boxOfficeUSGross = boxOfficeUSGross;
//        this.budget = budget;
//        this.originalAuthor = originalAuthor;
//        this.originalSource = originalSource;
//    }

    private boolean isNull(String data) {
        if (data.equals("NULL")){
            return true;
        }
        return false;
    }


    public void setMovieId(String movieId) {
        if(isNull(movieId)){
            throw new IllegalArgumentException("movieId가 null 일수는 없습니다.");
        }
        this.movieId = Integer.parseInt(movieId);
    }

    public void setTitle(String title) {
        if(isNull(title)){
            throw new IllegalArgumentException("title이 null 일수는 없습니다.");
        }
        this.title = title;
    }

    public void setKoreanTitle(String koreanTitle) {
        this.koreanTitle = koreanTitle;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setReleaseYear(String releaseYear) {
        if(isNull(releaseYear)) {
            this.releaseYear = 0;
        }else {
            this.releaseYear = Integer.valueOf(releaseYear);
        }
    }

    public void setRunningTime(String runningTime) {
        if(isNull(runningTime)) {
            this.runningTime = 0;
            return;
        }
        this.runningTime = Integer.parseInt(runningTime);
    }

    public void setGradeID(String gradeID) {
        if(isNull(gradeID)){
            this.gradeID = 0;
            return;
        }
        this.gradeID = Integer.parseInt(gradeID);
    }

    public void setGradInKoreaID(String gradInKoreaID) {
        if(isNull(gradInKoreaID)) {
            this.gradInKoreaID = 0;
            return;
        }
        this.gradInKoreaID = Integer.parseInt(gradInKoreaID);
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setDate(String date) {
        if (isNull(date)) {
            this.date = null;
            return;
        }
        this.date = LocalDate.parse(date); // 작동하는지 모름
    }

    public void setBoxOfficeWWGross(String boxOfficeWWGross) {
        if(isNull(boxOfficeWWGross))
        {
            this.boxOfficeWWGross = 0l;
            return;
        }
        this.boxOfficeWWGross = Long.parseLong(boxOfficeWWGross);
    }

    public void setBoxOfficeUSGross(String boxOfficeUSGross) {
        if(isNull(boxOfficeUSGross)){
            this.boxOfficeUSGross = 0l;
            return;
        }
        this.boxOfficeUSGross = Long.parseLong(boxOfficeUSGross);
    }

    public void setBudget(String budget) {
        if(isNull(budget)) {
            this.budget = 0;
            return;
        }
        this.budget = Integer.parseInt(budget);
    }

    public void setOriginalAuthor(String originalAuthor) {
        this.originalAuthor = originalAuthor;
    }

    public void setOriginalSource(String originalSource) {
        this.originalSource = originalSource;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getKoreanTitle() {
        return koreanTitle;
    }

    public String getPlot() {
        return plot;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public int getGradeID() {
        return gradeID;
    }

    public int getGradInKoreaID() {
        return gradInKoreaID;
    }

    public String getPoster() {
        return poster;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getBoxOfficeWWGross() {
        return boxOfficeWWGross;
    }

    public long getBoxOfficeUSGross() {
        return boxOfficeUSGross;
    }

    public long getBudget() {
        return budget;
    }

    public String getOriginalAuthor() {
        return originalAuthor;
    }

    public String getOriginalSource() {
        return originalSource;
    }

    @Override
    public String toString() {
        return "영화 제목 : " + this.koreanTitle + "\n"
                + "영화 영어 제목 : " + this.title + "\n"
                + "줄거리 : " + this.plot + "\n"
                + "개봉 연도 : " + this.releaseYear + "\n"
                + "상영 시간 : " + this.runningTime + "\n"
                + "한국 개봉 일자 : " + this.date + "\n"
                + "BoxOfficeWWGross : " + this.boxOfficeWWGross + "\n"
                + "BoxOfficeUsGross : " + this.boxOfficeUSGross + "\n"
                + "budget : " + this.budget + "\n"
                + "원작자 : " + this.originalAuthor + "\n"
                + "원작 : " + this.originalSource + "\n";
    }

    public void addDatas(CSVRecord csvRecord) {
        int count = 0;
        setMovieId(csvRecord.get(count++));
        setTitle(csvRecord.get(count++));
        setKoreanTitle(csvRecord.get(count++));
        setPlot(csvRecord.get(count++));
        setReleaseYear(csvRecord.get(count++));
        setRunningTime(csvRecord.get(count++));
        setGradeID(csvRecord.get(count++));
        setGradInKoreaID(csvRecord.get(count++));
        setPoster(csvRecord.get(count++));
        setDate(csvRecord.get(count++));
        setBoxOfficeWWGross(csvRecord.get(count++));
        setBoxOfficeUSGross(csvRecord.get(count++));
        setBudget(csvRecord.get(count++));
        setOriginalAuthor(csvRecord.get(count++));
        setOriginalSource(csvRecord.get(count++));
    }
}
