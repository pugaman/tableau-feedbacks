import { TableauFeedbacksClientPage } from './app.po';

describe('tableau-feedbacks-client App', () => {
  let page: TableauFeedbacksClientPage;

  beforeEach(() => {
    page = new TableauFeedbacksClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
