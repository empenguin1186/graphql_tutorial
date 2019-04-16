package jp.co.penguin.graphql.apps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {

    private String userId;

    private String userName;

    private String intro;

    private String place;

    private String birthDay;

    private String imgUrl;
}
