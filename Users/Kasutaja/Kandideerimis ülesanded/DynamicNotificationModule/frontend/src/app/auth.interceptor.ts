import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const username = 'admin';
  const password = 'admin123';

  const authHeader = 'Basic ' + btoa(`${username}:${password}`);

  const clonedRequest = req.clone({
    setHeaders: {
      Authorization: authHeader
    }
  });

  return next(clonedRequest);
};