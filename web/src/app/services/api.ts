import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";

export class Api {
    
    public url: string;

    constructor(
        public path: string,
        public http: HttpClient,
    ) {
        this.url = environment.api + '/' + path;
    }

    public post<T>(value: any) {
        return this.http.post<T>(this.url, value);
    }

    public get<T>() {
        return this.http.get<T>(this.url, {responseType: 'json'});
    }
}