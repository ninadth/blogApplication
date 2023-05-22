package com.bikkadit.curdopration.helper;

public class AppConstant {

	public static final String USER_SAVED = "All users saved successfully ";
	public static final String USER_DELETE = "User deleted successfully";
	public static final String POST_DELETE = "post deleted Successfully";
	public static final String CATOGORY_DELETE = "category deleted successfully";
	public static final String COMMENT_DELETE = "Comments deleted successfully";
	public static final String PAGE_NUMBER = "0";
	public static final String PAGE_SIZE = "2";
	public static final String SORT_BY = "postId";
	public static final String SORT_DIR = "desc";
	
	public static final String INVALID = "Invalid details .....";
	public static final String DETAILS = "Invalid username or password !!";
	
	public static final String KEY = "Authorization";
	public static final String START_WITH = "Bearer";
	public static final String UNABLE= "Unable to get Jwt token";
	public static final String EXPIRED  ="JWT token has expired .... !!";
	
	public static final String INVALID_JWT = " Invalid JWt token  .....";
	public static final String TOKEN_START = "JWT token does not starts with Bearer";
	public static final String ACCESS  ="Access  denied .....!!";
	public static final String IS_NULL = "username is null or  context is not null";

	
	public static final Integer USER_NORMAL = 102;
	public static final Integer USER_ADMIN  =101;

	public static final String[] PUBLIC_URLS = { "/api/v1/auth/**", "/v3/api-docs", "/v2/api-docs",
			"/swagger-resources/**", "swagger-ui/**", "webjars/**" };
	
}
