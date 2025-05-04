import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DatabaseService {

  constructor(private http: HttpClient) {
  }

  public loadPokemon(): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/pokemon/load', null);
  }

  public loadSinnohMap(): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/sinnoh-map/load', null);
  }

  public clearDatabase(): Observable<any> {
    return this.http.delete<any>('http://localhost:8080/api/database');
  }
}
