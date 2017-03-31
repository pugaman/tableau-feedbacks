import {Component, OnInit} from '@angular/core';
import {Link} from "./link/link";
import {routes} from "../../module/app-routing/routes";
import {Route} from "@angular/router";

@Component({
  selector: 'my-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  links: Link[];

  constructor() {
    this.links = [];
  }

  ngOnInit() {
    for (let route of routes) {
      if (route.path) {
        const link: Link = new Link(this.getLinkFromRoutePath(route.path), this.getTitleFromRoutePath(route.path));
        this.links.push(link);
      }
    }
  }

  private getLinkFromRoutePath(path: string): string {
    const link = '/' + path;
    return link;
  }

  private getTitleFromRoutePath(path: string): string {
    const title = path.slice(0, 1).toUpperCase() + path.slice(1, path.length);
    return title;
  }

}
