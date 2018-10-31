import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  constructor(private route: ActivatedRoute,
    private userService: UserService,
    private location: Location) { }

  ngOnInit() {
  }

  addUser(name: string, contact: number, city: string): void {
    this.userService.addUser({ name, contact, city } as User)
      .subscribe(() => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }

}
