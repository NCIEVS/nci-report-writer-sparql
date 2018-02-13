import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpResponse } from '@angular/common/http';

import { LoaderService } from './loader.service';
import { getBaseLocation } from './common-functions';

@Injectable()
export class HttpService implements HttpInterceptor {

    constructor (private loaderService: LoaderService) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      const url = getBaseLocation();
      console.log("url - " + url);
      //const url1 = "/ncireportwriter";
      //console.log("url1 - " + url1);
      req = req.clone({
        url: url + req.url
      });
        // start our loader here
        this.loaderService.showLoader();
    
        return next.handle(req).do((event: HttpEvent<any>) => {
          // if the event is for http response
          if (event instanceof HttpResponse) {
            // stop our loader here
            this.loaderService.hideLoader();
          }    
        }, (err: any) => {
          // if any error (not for just HttpResponse) we stop our loader bar
          this.loaderService.hideLoader();
        });
      }
}