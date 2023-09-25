package com.nhnacademy;

import java.util.Scanner;

public class Main {

    // TODO: csv -> 최상위
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String path = "src/main/resources/Movie.csv"; // 터미널 입력시 파일 경로

        MovieList movieList = new MovieList(path); // 파일 읽기
        System.out.println(path + "파일을 읽었습니다.");




        // TODO: 사용자 검색하는 부분 구현
        String title;
        while (true) {
            System.out.println();
            System.out.println("검색할 영화 제목을 입력하세요 (종료: 엔터)");

            title = sc.nextLine();

            if (title.isEmpty()) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            Movie searchedMovie = movieList.searchMovie(title);

            if (searchedMovie == null) {
                System.out.println("찾으시는 영화가 없습니다. \n다시 입력해주세요");
                continue;
            }
            System.out.println("찾으시는 영화\n" + searchedMovie);
        }

        sc.close();
    }


}