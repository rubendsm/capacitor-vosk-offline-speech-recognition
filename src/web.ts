import { WebPlugin } from '@capacitor/core';

import type { VoskPlugin } from './definitions';

export class VoskWeb extends WebPlugin implements VoskPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
