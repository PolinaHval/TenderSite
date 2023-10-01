//package org.teachmeskills.interceptor;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.lang.NonNull;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.teachmeskills.session.AuthContext;
//
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@RequiredArgsConstructor
//public class AuthInterceptor implements HandlerInterceptor {
//
//  private final AuthContext authContext;
//
//  @Override
//  public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
//                           @NonNull Object handler) throws Exception {
//    if (authContext.getLoggedInUserId() != null || authContext.getOrganizationId() != null) {
//      return true;
//    }
//    response.sendRedirect("accessDenied");
//    return false;
//  }
//}
