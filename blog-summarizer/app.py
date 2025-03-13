from flask import Flask, request, jsonify
import spacy

# Load spaCy model
nlp = spacy.load("en_core_web_sm")

app = Flask(__name__)

@app.route("/summarize", methods=["POST"])
def summarize():
    data = request.json
    text = data.get("content", "")

    if not text:
        return jsonify({"error": "No content provided"}), 400

    # NLP Processing
    doc = nlp(text)
    sentences = [sent.text for sent in doc.sents]

    # Simple summarization: Return first 2 sentences
    summary = " ".join(sentences[:2])

    return jsonify({"summary": summary})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
