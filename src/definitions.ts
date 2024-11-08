import type { PermissionState, PluginListenerHandle } from '@capacitor/core';

export interface PermissionStatus {
  /**
   * Permission state for speechRecognition alias.
   *
   * On Android it requests/checks RECORD_AUDIO permission
   *
   * On iOS it requests/checks the speech recognition and microphone permissions.
   *
   */
  speechRecognition: PermissionState;
}

export interface VoskPlugin {
  //echo(options: { value: string }): Promise<{ value: string }>;
  //initModel(): Promise<void>; Now the model initiates on plugin load
  startListening(): Promise<void>;
  stopListening(): Promise<void>;
  pauseListening(): Promise<void>;
  resumeListening(): Promise<void>;
  isListening(): Promise<{ isListening: boolean }>;
  available(): Promise<{ available: boolean }>;
  requestPermissions(): Promise<PermissionStatus>;
  
  // Listeners
  addListener(
    eventName: 'partialResult',
    listener: (data: { matches: string }) => void
  ): Promise<PluginListenerHandle>;

    /* its Called after stream end so thats not interesting, i want the result after user stops talking
  addListener(
    eventName: 'finalResult',
    listener: (data: { result: string }) => void
  ): Promise<PluginListenerHandle>; */

  addListener(
    eventName: 'onResult',
    listener: (data: { result: string }) => void
  ): Promise<PluginListenerHandle>;
}
