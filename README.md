# Audio Collage Creator

A Java program that creates musical collages by combining and transforming audio samples.

## Audio Effects Implemented

1. **Amplify**: Adjusts volume by multiplying samples by a factor
   ```java
   public static double[] amplify(double[] a, double alpha)
   ```

2. **Reverse**: Plays sound backwards by reversing sample array
   ```java
   public static double[] reverse(double[] a)
   ```

3. **Merge**: Combines sounds sequentially (A then B)
   ```java
   public static double[] merge(double[] a, double[] b)
   ```

4. **Mix**: Overlays sounds simultaneously (A + B)
   ```java
   public static double[] mix(double[] a, double[] b)
   ```

5. **Change Speed**: Alters duration via resampling
   ```java
   public static double[] changeSpeed(double[] a, double alpha)
   ```

## Usage

1. **Compile** the program:
   ```bash
   javac AudioCollage.java
   ```

2. **Run** the program (no arguments needed):
   ```bash
   java AudioCollage
   ```

The program will:
- Read several WAV files
- Apply various audio effects
- Combine them into a new composition
- Play the resulting collage

## Requirements

- Composition length: 10-60 seconds (441,000-2,646,000 samples)
- Uses ≥5 different WAV files
- All samples normalized to [-1, +1] range
- Implements all 5 required effects
- No mutation of input arrays

## Example Audio Files Provided

- [beatbox.wav](beatbox.wav)
- [buzzer.wav](buzzer.wav) 
- [chimes.wav](chimes.wav)
- [cow.wav](cow.wav)
- [dialup.wav](dialup.wav)
- [harp.wav](harp.wav)
- [piano.wav](piano.wav)

## Implementation Details

- Uses `StdAudio` for playback and WAV file I/O
- Carefully handles array bounds and sample ranges
- Creates new arrays rather than mutating inputs
- Implements resampling for speed changes
- Automatically pads shorter arrays when mixing

## Creative Possibilities

Try combining effects like:
- Reverse then mix with original
- Slow down then amplify
- Merge multiple sped-up versions
- Layer rhythmic and melodic elements
