import { DemoMaterialPage } from './app.po';

describe('demo-material App', () => {
  let page: DemoMaterialPage;

  beforeEach(() => {
    page = new DemoMaterialPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
