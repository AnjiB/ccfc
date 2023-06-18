package com.anji.finance.ccfc.sec;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.anji.finance.ccfc.dto.CCFraudInfo;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AppBasicAuthenticationEntryPoint
    extends BasicAuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authEx) throws IOException {

    response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.setContentType("application/json");
    PrintWriter writer = response.getWriter();
    CCFraudInfo ccr = CCFraudInfo.builder().error(authEx.getMessage()).build();
    writer.println(getMapper().writeValueAsString(ccr));
  }

  @Override
  public void afterPropertiesSet() {
    setRealmName("abtesting");
    super.afterPropertiesSet();
  }
  
  private ObjectMapper getMapper() {
	  ObjectMapper mapper = new ObjectMapper();
	  mapper.setSerializationInclusion(Include.NON_DEFAULT);
	  return mapper;
  }
}
