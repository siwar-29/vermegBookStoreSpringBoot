import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../Models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private url="http://localhost:9000/books"

  httpOptions ={
    headers: new HttpHeaders({
      'Content-Type':'application/json',
      'Access-Control-Allow-Origin':'*',
    })
 }


  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<Book> {
    return this.http.get<Book>(this.url+"/all", this.httpOptions)
  }

  getBookById(id): Observable<Book> {
    return this.http.get<Book>(this.url+"/get/"+id, this.httpOptions)
  }

  addBook(book: Book): Observable<Book> {
    return this.http.post<Book>(this.url+"/add", book, this.httpOptions)
  }

  updateBook(id, book:Book): Observable<Book> {
    return this.http.put<Book>(this.url+"/update", book, this.httpOptions)
  }

  deleteBook(id): Observable<Book> {
    return this.http.delete<Book>(this.url+"/remove"+id, this.httpOptions)

  }




}
