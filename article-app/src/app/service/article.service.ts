import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RestResponse } from '../model/restresponse';
import { Article } from '../model/article';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  URL_API = environment.URL_API;

  constructor(private http: HttpClient) { }

  getAllArticle(): Observable<RestResponse> {
    return this.http.get<RestResponse>(this.URL_API);
  }

  postArticle(article: Article) {
    return this.http.post<RestResponse>(this.URL_API, article);
  }

  putArticle(id: number, article: Article) {
    return this.http.put<RestResponse>(this.URL_API + id, article);
  }

  deleteArticle(id: number) {
    return this.http.delete<RestResponse>(this.URL_API + id);
  }

}
