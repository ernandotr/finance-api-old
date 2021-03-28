package com.ernando.finance.response;

import java.net.URI;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HomeResponse {
	
	private String apiVersion;
	private String apiName;
	private URI	apiDocs;
}
