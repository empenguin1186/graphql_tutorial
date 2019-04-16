package jp.co.penguin.graphql.apps.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userId;

    private String userName;

    private String intro;

    private String place;

    private String birthDay;

    private String imgUrl;
}
