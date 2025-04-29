public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * alpha;
        }
        return result;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int maxLength = Math.max(a.length, b.length);
        double[] result = new double[maxLength];
        for (int i = 0; i < maxLength; i++) {
            double aVal = i < a.length ? a[i] : 0.0;
            double bVal = i < b.length ? b[i] : 0.0;
            result[i] = aVal + bVal;
        }
        return result;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int)(a.length / alpha);
        double[] result = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            int index = (int)(i * alpha);
            if (index >= a.length) index = a.length - 1;
            result[i] = a[index];
        }
        return result;
    }

    public static void main(String[] args) {
        // Read at least 5 WAV files
        double[] sample1 = StdAudio.read("piano.wav");
        double[] sample2 = StdAudio.read("harp.wav");
        double[] sample3 = StdAudio.read("cow.wav");
        double[] sample4 = StdAudio.read("chimes.wav");
        double[] sample5 = StdAudio.read("buzzer.wav");
        
        // Apply all required operations
        double[] amplified = amplify(sample1, 0.5);
        double[] reversed = reverse(sample2);
        double[] merged = merge(sample3, sample4);
        double[] mixed = mix(sample5, sample1);
        double[] speedChanged = changeSpeed(sample2, 1.5);
        
        // Combine everything into a collage
        double[] collage = merge(amplified, reversed);
        collage = merge(collage, merged);
        collage = merge(collage, mixed);
        collage = merge(collage, speedChanged);
        
        // Ensure samples are within [-1, 1]
        for (int i = 0; i < collage.length; i++) {
            if (collage[i] < -1.0) collage[i] = -1.0;
            if (collage[i] > 1.0) collage[i] = 1.0;
        }
        
        StdAudio.play(collage);
    }
}