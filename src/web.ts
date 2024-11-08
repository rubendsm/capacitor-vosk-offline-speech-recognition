import { WebPlugin } from '@capacitor/core';

import type { VoskPlugin } from './definitions';

export class VoskWeb extends WebPlugin implements VoskPlugin {
  pauseListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  resumeListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  startListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  stopListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  isListening(): Promise<{ isListening: boolean; }> {
    throw new Error('Method not implemented.');
  }
  requestMicrophonePermission(): Promise<void> {
    throw new Error('Method not implemented.');
  }

}
