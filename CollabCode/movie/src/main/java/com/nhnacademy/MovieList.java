package com.nhnacademy;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class MovieList {

    // movieId, movie
    private final HashMap<Integer, Movie> movieList;

    //String -> 영화 제목, Integer -> movieId
    private Map<String, Integer> movieIndexList;

    public MovieList(String path) {
        this.movieList = new HashMap<>();
        this.movieIndexList = new HashMap<>();

        readFile(path);
    }

    /**
     *
     * @param path
     * 파일 경로를 받아서 영화파일을 읽어와서 movielist에
     * 추가하는 메서드
     */
    private void readFile(String path) {
        File file = new File(path);

        try {
            FileReader csvData = new FileReader(file);
            if (csvData.read() == -1) {
                throw new IOException("잘못된 경로입니다.");
            }

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader("MovieID", "Title", "KoreanTitle", "Plot", "ReleaseYear", "RunningTime", "GradeID",
                            "GradeInKoreaID", "Poster", "ReleaseDateInKorea", "BoxOfficeWWGross", "BoxOfficeUSGross",
                            "Budget", "OriginalAuthor", "OriginalSource").setSkipHeaderRecord(true).build();


            Iterable<CSVRecord> recodes = csvFormat.parse(csvData);


            addMovie(recodes);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     *
     * @param recodes
     * movie를 읽어서 각 의미별로 분리시켜서 movielist에 추하가는 메서드
     */
    private void addMovie(Iterable<CSVRecord> recodes) {
        // TODO: Key 값(Set<String>), Value Movie 객체


        for (CSVRecord csvRecord : recodes) {
            Movie movie = new Movie();
            movie.addDatas(csvRecord);

            this.movieList.put(movie.getMovieId(), movie);
            if (!(movie.getKoreanTitle().equals("NULL"))) {
                this.movieIndexList.put(movie.getKoreanTitle(), movie.getMovieId());
            }
            this.movieIndexList.put(movie.getTitle(), movie.getMovieId());
        }
    }

    public Movie searchMovie(String searchName) {
        int index = 0;

        if (movieIndexList.get(searchName) == null) {
            return null;
        } else {
            index = movieIndexList.get(searchName);
        }

        Movie searchedMovie = movieList.get(index);
        return searchedMovie;
    }
}
