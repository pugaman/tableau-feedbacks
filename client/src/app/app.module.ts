import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {HeaderComponent} from './component/header/header.component';
import {ContentComponent} from './component/content/content.component';
import {NavigationComponent} from './component/navigation/navigation.component';
import {ReportComponent} from './component/report/report.component';
import {AppRoutingModule} from "./module/app-routing/app-routing.module";
import { SettingsComponent } from './component/settings/settings.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ContentComponent,
    NavigationComponent,
    ReportComponent,
    SettingsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
