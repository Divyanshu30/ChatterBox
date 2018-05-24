import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../model/user';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

 public users: User[];
 public errorMsg; 
  constructor(private router: ActivatedRoute , private userService: UserService) { }

  ngOnInit() { 
 // this.getAllUsers;
  this.userService.getAllUsers().subscribe((users)=>{
    console.log(users);
  this.users=users;
  },(error)=>{console.log(error);
    })
}
  // getAllUsers(): void
  // {
  // this.userService.getAllUsers()
  // .subscribe(data =>this.users = data,
  //  error => this.errorMsg = error);  
  //  }

}
