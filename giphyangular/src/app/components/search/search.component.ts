import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import  {FormBuilder, FormGroup} from '@angular/forms'
import { Subscription } from 'rxjs/internal/Subscription';
import { ServiceService } from 'src/app/service/service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  form! : FormGroup
  name! : string
  sub$! : Subscription
  image : any[] = []
  constructor(private fb:FormBuilder, private service : ServiceService){}
  
  ngOnInit(): void {

    this.form = this.fb.group({
      name: this.fb.control<string>('')
    })
  }

  searchGif(){
    this.image = [];
    this.name = this.form.value['name'];
    console.log(this.name)

    this.sub$ = this.service.getGif(this.name).subscribe({
      next: (result) => {
        for (let index = 0; index < result.length; index++) {
          const element = result[index];

          this.image.push(element);
          
        }
       },
      error: (err) => {console.error(err)},
      complete: () => { this.sub$.unsubscribe()}
    })
    
    console.log(">>>urls " + this.image);

  }



}
