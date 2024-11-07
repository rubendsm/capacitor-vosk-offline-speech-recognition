import { WebPlugin } from '@capacitor/core';

import type { VoskPlugin } from './definitions';

export class VoskWeb extends WebPlugin implements VoskPlugin {
  initModel(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  echo(): Promise<{ value: string; }> {
    throw new Error('Method not implemented.');
  }

  startListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  stopListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  isListening(): Promise<{ listening: boolean; }> {
    throw new Error('Method not implemented.');
  }
  requestMicrophonePermission(): Promise<void> {
    throw new Error('Method not implemented.');
  }

}
