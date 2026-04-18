import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withInterceptors } from '@angular/common/http';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    provideHttpClient(
      withInterceptors([
        (req, next) => {

          const isAdmin = req.url.includes('/api/admin');

          if (isAdmin) {
            const credentials = btoa('admin:admin123');

            return next(req.clone({
              setHeaders: {
                Authorization: `Basic ${credentials}`
              }
            }));
          }

          return next(req);
        }
      ])
    )
  ]
};