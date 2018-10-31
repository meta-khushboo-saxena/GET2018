import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  user: User;

  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getUserById();
  }

  getUserById(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.userService.getUserById(id)
      .subscribe(user => this.user = user);
  }

  editUser(): void {
    this.userService.updateUser(this.user)
      .subscribe(() => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }

}
