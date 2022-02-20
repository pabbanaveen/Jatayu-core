package com.my.jatayu.demo.jwt;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

    private static final long serialVersionUID = 8317676219297719109L;

    private final String token;
    private final String message;

      public JwtTokenResponse(String token, String message) {
          this.token = token;
          this.message = message;
      }

      public String getToken() {
          return this.token;
      }
      
      public String getMessage() {
          return this.message;
      }
  }
