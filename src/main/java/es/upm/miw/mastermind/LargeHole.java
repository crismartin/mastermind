package es.upm.miw.mastermind;

public class LargeHole {
    private CodepegColor codepegColor;

    public LargeHole(){
        this.set(CodepegColor.NULL_TOKEN);
    }

    public LargeHole(CodepegColor codepegColor){
        this.set(codepegColor);
    }

    public CodepegColor getColor(){
        return this.codepegColor;
    }

    public void set(CodepegColor codepegColor){
        this.codepegColor = codepegColor;
    }

    public static String readLargeHoles(LargeHole[] largeHoles){
        StringBuilder result = new StringBuilder();
        for(LargeHole largeHole: largeHoles){
            result.append(largeHole.getColor().getSymbol());
        }
        return result.toString();
    }

}
