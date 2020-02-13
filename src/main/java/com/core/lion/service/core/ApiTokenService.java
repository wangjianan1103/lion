package com.core.lion.service.core;

public interface ApiTokenService {

    boolean checkApiUtc(long uid, String t);

    String getUtcToken(long uid);

    String generateToken(long uid);

}
