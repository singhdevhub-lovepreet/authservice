package authservice.service;

import authservice.entities.RefreshToken;
import authservice.entities.UserInfo;
import authservice.repository.RefreshTokenRepository;
import authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    UserRepository userRepository;

    public RefreshToken createRefreshToken(String username){
        UserInfo userInfoExtracted = userRepository.findByUsername(username);
        RefreshToken refreshToken = RefreshToken.builder()
                    .userInfo(userInfoExtracted)
                    .token(UUID.randomUUID().toString())
                    .expiryDate(Instant.now().plusMillis(600000))
                    .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;
    }

}