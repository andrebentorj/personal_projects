import { HttpInterceptorFn } from '@angular/common/http';
import { HttpRequest, HttpEvent, HttpHandlerFn } from '@angular/common/http';
import { Observable } from 'rxjs';

export const basicAuthInterceptorFn: HttpInterceptorFn =
  (req: HttpRequest<unknown>, next: HttpHandlerFn): Observable<HttpEvent<unknown>> => {
    const USERNAME = 'admin';
    const PASSWORD = 'admin123';
    const basicAuth = 'Basic ' + btoa(`${USERNAME}:${PASSWORD}`);

    const cloned = req.clone({
      setHeaders: { Authorization: basicAuth }
    });
    return next(cloned);
  };