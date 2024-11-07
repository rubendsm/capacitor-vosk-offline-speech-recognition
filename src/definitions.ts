export interface VoskPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
