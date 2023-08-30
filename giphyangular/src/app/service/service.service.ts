import { HttpClient, HttpParams } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Gif } from '../model/gif';
import { Observable } from 'rxjs/internal/Observable';

const URL = '/search'

@Injectable({
  providedIn: 'root'
})



export class ServiceService {

  constructor(private httpClient : HttpClient) { }
  

  getGif(name: string) : Observable<any>{
    
    const params = new HttpParams()
                  .set('name', name)

    return this.httpClient.get(URL, {params : params})

    


  }
}
