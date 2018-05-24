import { Injectable } from '@angular/core';
import { User } from './model/user';
import { Http, Headers, Response, RequestOptions, } from '@angular/http';
import { Observable  } from 'rxjs';
//import { of } from 'rxjs/Observable/of';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

  // const httpOptions = {
  // headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  // }

@Injectable()
export class UserService {
  private userUrl: string = 'http://localhost:9002/ChatterBoxMiddleware/api/allUser';
  private headers =new Headers({'Content-Type': 'application/json'});
  private options =new RequestOptions({headers:this.headers});
  constructor(private http: Http) 
  { }
  
  public getAllUsers() {
   return this.http.get(this.userUrl,this.options).map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  public errorHandler(error: Response)
  {
    return Observable.throw(error || "Server Error") ;
  }

}
